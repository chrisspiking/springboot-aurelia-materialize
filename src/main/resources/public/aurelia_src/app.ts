import {Router, RouterConfiguration} from 'aurelia-router';

export class App {

    router: Router;

    constructor() {

    }

    public configureRouter(config: RouterConfiguration, router: Router): void {
        this.router = router;
        config.title = 'Spring Boot Aurelia Materialize';

        config.map([
            {route: 'select-view',  name: 'select-view',  moduleId: './features/select-view/select-view', title: 'Select View', nav: true},
            {route: '/', redirect: 'select-view'}
        ]);

        config.mapUnknownRoutes(() => {
            return '/';
        });
    }

}