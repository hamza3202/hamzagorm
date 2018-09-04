package hamzagorm

import grails.transaction.Transactional

@Transactional
class GlobalIdStoreService {

    GlobalIdStore save(String publicId) {
        new GlobalIdStore(publicId: publicId).save()
    }
}
