package hamzagorm

import grails.test.mixin.integration.Integration
import grails.transaction.Rollback

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
