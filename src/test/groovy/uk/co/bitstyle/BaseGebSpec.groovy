package uk.co.bitstyle

import geb.driver.CachingDriverFactory
import geb.spock.GebSpec
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import uk.co.bitstyle.fetests.Application

/**
 * Base test class to load things correctly.
 *
 * @author cspiking
 */

@SpringBootTest(classes = [Application.class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BaseGebSpec extends GebSpec {
    def setupSpec() {
        browser.driver.manage().window().maximize()
    }

    def cleanupSpec() {
        CachingDriverFactory.clearCache()
    }

    @Value('${local.server.port}')
    int port

    def setup() {
        browser.setBaseUrl("http://localhost:${port}")
    }
}
