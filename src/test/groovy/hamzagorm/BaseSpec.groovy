package hamzagorm

import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Specification
import spock.lang.Stepwise

@Integration
@Rollback
@Stepwise
class BaseSpec extends Specification {
}
