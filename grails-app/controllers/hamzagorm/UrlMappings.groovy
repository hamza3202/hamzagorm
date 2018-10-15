package hamzagorm

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        '/data-privacy'(controller: 'publicInfo', action: 'dataPrivacy')
        '/data-privacy-with-view-specified'(controller: 'publicInfo', action: 'dataPrivacyViewSpecified')

        "/"(view: '/index')
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
