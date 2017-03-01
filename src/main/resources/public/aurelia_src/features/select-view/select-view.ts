import 'materialize-css';

export class SelectView {

    private selectedOption: any = null;

    private selectionOptions: Array<any> = [
        {valueOne: "Hello", valueTwo: "World!"},
        {valueOne: "Scooby", valueTwo: "Doo"},
        {valueOne: "Fred", valueTwo: "Flintstone"},
        {valueOne: "Wilma", valueTwo: "Flintstone"}
    ];
}