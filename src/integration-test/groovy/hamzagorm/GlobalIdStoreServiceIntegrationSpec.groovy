package hamzagorm

import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Specification

@Integration
class GlobalIdStoreServiceIntegrationSpec extends Specification {

    GlobalIdStoreService globalIdStoreService

    @Rollback
    void 'test unique constraint'() {
        // just verifying that GORM is accessible as expected in this @Rollback method
        expect:
        globalIdStoreService.save 'testPublicId'
        globalIdStoreService.save 'anotherTestPublicId'
        !globalIdStoreService.save('testPublicId')
    }
}
