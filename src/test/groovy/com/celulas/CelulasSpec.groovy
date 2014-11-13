package com.celulas

import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * User: pinky
 * Date: 11/12/14
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
class CelulasSpec extends Specification{

    void "must print hola mundo"() {
        setup:
        Celulas celulas = new Celulas()

        when:
         def response = celulas.imprime()
        then:
         assert response == "Hola mundo"
    }

    void "must create a file"(){
        setup:
          Celulas celulas = new Celulas()
        when:
          def response = celulas.creaArchivo()
        then:
          assert response

    }
}
