import {Router, RouterConfiguration} from 'aurelia-router';

export class App {

    router: Router;

    constructor() {

    }

    public configureRouter(config: RouterConfiguration, router: Router): void {
        this.router = router;
        config.title = 'FrontendTests';

        config.map([
            {route: 'select-view',  name: 'select-view',  moduleId: './features/select-view/select-view', title: 'Select View', nav: true},
            {route: 'm-select-view',  name: 'm-select-view',  moduleId: './features/materialize-select-view/select-view', title: 'Materialize Select View', nav: true},
            {route: '/', redirect: 'm-select-view'}
        ]);

        config.mapUnknownRoutes(() => {
            return '/';
        });
    }

}