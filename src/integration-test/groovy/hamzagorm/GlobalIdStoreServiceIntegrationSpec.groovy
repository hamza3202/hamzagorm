package hamzagorm

class GlobalIdStoreServiceIntegrationSpec extends BaseSpec {

    GlobalIdStoreService globalIdStoreService

    void 'test unique constraint'() {
        // just verifying that GORM is accessible as expected in this @Rollback method
        when: "dummy user is saved and account is unlocked"
        GlobalIdStore globalIdStore = new GlobalIdStore()
        globalIdStore.publicId = "testPublicID"
        globalIdStore.save(flush: true, failOnError: true)

        then:
        globalIdStoreService.save 'testPublicId'
        globalIdStoreService.save 'anotherTestPublicId'
        !globalIdStoreService.save('testPublicId')
    }
}
