import {Aurelia} from 'aurelia-framework';

export function configure(aurelia: Aurelia) {
    let materialize = 'materialize-css';

    aurelia.use
        .standardConfiguration()
        .developmentLogging()
        .plugin('aurelia-materialize-bridge', bridge => bridge.useAll() )
        .globalResources([
            'aurelia_src/resources/on-enter',
            'aurelia_src/resources/valueconverters/date-format',
            'aurelia_src/resources/valueconverters/json-string',
            'aurelia_src/resources/valueconverters/to-uppercase',
            'aurelia_src/resources/valueconverters/syntax-highlight',
            'aurelia_src/resources/valueconverters/object-keys'
        ]);

    aurelia.start().then(() => aurelia.setRoot('aurelia_src/app'));
}