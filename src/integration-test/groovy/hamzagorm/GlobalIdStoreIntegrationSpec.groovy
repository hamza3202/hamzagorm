package hamzagorm

import grails.test.mixin.integration.Integration
import grails.transaction.Rollback

import spock.lang.Specification


@Integration
class GlobalIdStoreIntegrationSpec extends Specification {

    @Rollback
    void 'test unique constraint'() {
        // just verifying that GORM is accessible as expected in this @Rollback method
        when:
        GlobalIdStore globalIdStore = new GlobalIdStore()
        globalIdStore.publicId = "testPublicId"

        then:
        globalIdStore.save()

        when:
        globalIdStore = new GlobalIdStore()
        globalIdStore.publicId = "anotherTestPublicId"

        then:
        globalIdStore.save()

        when:
        globalIdStore = new GlobalIdStore()
        globalIdStore.publicId = "testPublicId"

        then:
        !globalIdStore.save()
    }
}
