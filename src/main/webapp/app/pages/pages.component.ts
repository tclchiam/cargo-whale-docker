import {Component} from "@angular/core";

@Component({
    selector: 'cw-pages',
    template: `
<cw-sidebar></cw-sidebar>
<cw-header></cw-header>
<main>
    <div class="content">
        <div class="container-fluid">
            <router-outlet></router-outlet>
        </div>
    </div>
</main>
`
})
export class PagesComponent {

}