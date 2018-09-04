package hamzagorm

// Will have same result if you use grails.transaction.Rollback
import grails.gorm.transactions.Rollback

import grails.testing.mixin.integration.Integration
import spock.lang.Specification


@Integration
class WidgetIntegrationSpec extends Specification {

    @Rollback
    void 'test unique constraint'() {
        expect:
        // just verifying that GORM is accessible as expected in this @Rollback method
        new Widget(name: 'Widget One').save()
        new Widget(name: 'Widget Two').save()
        !new Widget(name: 'Widget One').save()
    }
}
