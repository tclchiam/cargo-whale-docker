'use strict';

module.exports = {
    app: 'src/main/webapp/',
    dist: 'target/www/',
    scssMainDir: 'src/main/webapp/scss/',
    bower: 'src/main/webapp/bower_components/',
    sassMainSrc: 'src/main/webapp/scss/**/*.{scss,sass}',
    sassAppSrc: 'src/main/webapp/app/**/*.{scss,sass}',
    sassVendor: 'src/main/webapp/scss/vendor.scss',
    cssDir: 'src/main/webapp/content/css',
    cssTargetDir: 'target/www/content/css',
    tmp: 'target/tmp',
    revManifest: 'target/tmp/rev-manifest.json',
    port: 9000,
    uri: 'http://localhost:',
    apiPort: 8081,
    constantTemplate: '// DO NOT EDIT THIS FILE, EDIT THE GULP TASK NGCONSTANT SETTINGS INSTEAD WHICH GENERATES THIS FILE\n' +
    '<% constants.forEach(function(constant) { %>export const <%- constant.name %> = <%= constant.value %>;\n<% }) %>' +
    '\n'
};