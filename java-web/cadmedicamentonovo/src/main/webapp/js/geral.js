var select2_default = {
    placeholder: 'Selecione...',
    allowClear: true
};

var select2_default_multi = {
    placeholder: 'Selecione...',
    allowClear: true,
    closeOnSelect: false
};

$(document).ready(function () {
    $(":input:visible:enabled:first").focus();
    $('.select-item').select2(select2_default);
    $('.date').datetimepicker({
        locale: 'pt-BR',
        format: 'DD/MM/YYYY'
    });
    // Altera o alert padrão.
    window.alert = bootbox.alert;
});

function editor(selector) {
    $.trumbowyg.svgPath = '../imagens/icons.svg';
    $(selector).trumbowyg({
        lang: 'pt_br',
        removeformatPasted: true,
        autogrow: true,
        height: 100,
        imgDblClickHandler: function () {
        },
        btns: [
            ['undo', 'redo'],
            ['strong', 'em', 'del', 'underline'],
            ['superscript', 'subscript'],
            ['justifyLeft', 'justifyCenter', 'justifyRight', 'justifyFull'],
            ['horizontalRule'],
            ['base64'],
            ['removeformat'],
            ['fullscreen']
        ]
    });
    $('[data-toggle="tooltip"]').tooltip();
}

function select2(selector) {
    $(document).ready(function () {
        $(selector).select2(select2_default);
    });
}

function select2_multi(selector) {
    $(document).ready(function () {
        $(selector).select2(select2_default_multi);
    });
}
