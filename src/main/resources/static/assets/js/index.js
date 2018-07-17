var go;

function initpage() {

}

function clickbutton() {
    var ii = 0;
     // $(".progress-bar").attr("style","width:0%");
    go = setInterval(function() {
        if (ii < 101) {
            var j = ii+"%";
            document.getElementById('jdt').style.width = j;
            $('#jdtz').attr('data-percent',j);
            ii++;
            // $("#jdt").attr("style",j);
        } else {
            setTimeout(function() {

                // content.innerHTML = '加载完成';

                clearInterval(go);
            }, 100);
        }
    }, 100);
    $.ajax({
        url:'/list/dothis',
        type:'GET',
        success:function (data) {

        }
    });
    // for (var i = 0;i<100;i++){
    //     sleep(1);
    //     var j = "width:"+i+"%";
    //     $("#jdt").attr("style",j);
    // }
}

function sleep(numberMillis) {
    var now = new Date();
    var exitTime = now.getTime() + numberMillis;
    while (true) {
        now = new Date();
        if (now.getTime() > exitTime)
            return;
    }
}

//添加同步表
function addsynctab() {
    layer.open({
        type: 1,
        title: '添加新的同步表',
        shadeClose: true,
        shade: 0.8,
        anim:4,
        area: ['500px', '720px'],
        content: '<form class="form-horizontal" role="form">\n' +
        '\t\t<div class="form-group">\n' +
        '\t\t\t<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Text Field </label>\n' +
        '\n' +
        '\t\t\t<div class="col-sm-9">\n' +
        '\t\t\t\t<input type="text" id="form-field-1" placeholder="Username" class="col-xs-10 col-sm-5" />\n' +
        '\t\t\t</div>\n' +
        '\t\t</div>\n' +
        '\n' +
        '\t\t<div class="space-4"></div>\n' +
        '\n' +
        '\t\t<div class="form-group">\n' +
        '\t\t\t<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> Password Field </label>\n' +
        '\n' +
        '\t\t\t<div class="col-sm-9">\n' +
        '\t\t\t\t<input type="password" id="form-field-2" placeholder="Password" class="col-xs-10 col-sm-5" />\n' +
        '\t\t\t\t<span class="help-inline col-xs-12 col-sm-7">\n' +
        '\t\t\t\t\t<span class="middle">Inline help text</span>\n' +
        '\t\t\t\t</span>\n' +
        '\t\t\t</div>\n' +
        '\t\t</div>\n' +
        '\n' +
        '\t\t<div class="space-4"></div>\n' +
        '\n' +
        '\t\t<div class="form-group">\n' +
        '\t\t\t<label class="col-sm-3 control-label no-padding-right" for="form-input-readonly"> Readonly field </label>\n' +
        '\n' +
        '\t\t\t<div class="col-sm-9">\n' +
        '\t\t\t\t<input readonly="" type="text" class="col-xs-10 col-sm-5" id="form-input-readonly" value="This text field is readonly!" />\n' +
        '\t\t\t\t<span class="help-inline col-xs-12 col-sm-7">\n' +
        '\t\t\t\t\t<label class="middle">\n' +
        '\t\t\t\t\t\t<input class="ace" type="checkbox" id="id-disable-check" />\n' +
        '\t\t\t\t\t\t<span class="lbl"> Disable it!</span>\n' +
        '\t\t\t\t\t</label>\n' +
        '\t\t\t\t</span>\n' +
        '\t\t\t</div>\n' +
        '\t\t</div>\n' +
        '\n' +
        '\t\t<div class="space-4"></div>\n' +
        '\n' +
        '\t\t<div class="form-group">\n' +
        '\t\t\t<label class="col-sm-3 control-label no-padding-right" for="form-field-4">Relative Sizing</label>\n' +
        '\n' +
        '\t\t\t<div class="col-sm-9">\n' +
        '\t\t\t\t<input class="input-sm" type="text" id="form-field-4" placeholder=".input-sm" />\n' +
        '\t\t\t\t<div class="space-2"></div>\n' +
        '\n' +
        '\t\t\t\t<div class="help-block" id="input-size-slider"></div>\n' +
        '\t\t\t</div>\n' +
        '\t\t</div>\n' +
        '\n' +
        '\t\t<div class="form-group">\n' +
        '\t\t\t<label class="col-sm-3 control-label no-padding-right" for="form-field-5">Grid Sizing</label>\n' +
        '\n' +
        '\t\t\t<div class="col-sm-9">\n' +
        '\t\t\t\t<div class="clearfix">\n' +
        '\t\t\t\t\t<input class="col-xs-1" type="text" id="form-field-5" placeholder=".col-xs-1" />\n' +
        '\t\t\t\t</div>\n' +
        '\n' +
        '\t\t\t\t<div class="space-2"></div>\n' +
        '\n' +
        '\t\t\t\t<div class="help-block" id="input-span-slider"></div>\n' +
        '\t\t\t</div>\n' +
        '\t\t</div>\n' +
        '\n' +
        '\t\t<div class="form-group">\n' +
        '\t\t\t<label class="col-sm-3 control-label no-padding-right">Input with Icon</label>\n' +
        '\n' +
        '\t\t\t<div class="col-sm-9">\n' +
        '\t\t\t\t<span class="input-icon">\n' +
        '\t\t\t\t\t<input type="text" id="form-field-icon-1" />\n' +
        '\t\t\t\t\t<i class="icon-leaf blue"></i>\n' +
        '\t\t\t\t</span>\n' +
        '\n' +
        '\t\t\t\t<span class="input-icon input-icon-right">\n' +
        '\t\t\t\t\t<input type="text" id="form-field-icon-2" />\n' +
        '\t\t\t\t\t<i class="icon-leaf green"></i>\n' +
        '\t\t\t\t</span>\n' +
        '\t\t\t</div>\n' +
        '\t\t</div>\n' +
        '\n' +
        '\t\t<div class="space-4"></div>\n' +
        '\n' +
        '\t\t<div class="form-group">\n' +
        '\t\t\t<label class="col-sm-3 control-label no-padding-right" for="form-field-6">Tooltip and help button</label>\n' +
        '\n' +
        '\t\t\t<div class="col-sm-9">\n' +
        '\t\t\t\t<input data-rel="tooltip" type="text" id="form-field-6" placeholder="Tooltip on hover" title="Hello Tooltip!" data-placement="bottom" />\n' +
        '\t\t\t\t<span class="help-button" data-rel="popover" data-trigger="hover" data-placement="left" data-content="More details." title="Popover on hover">?</span>\n' +
        '\t\t\t</div>\n' +
        '\t\t</div>\n' +
        '\n' +
        '\t\t<div class="space-4"></div>\n' +
        '\n' +
        '\t\t<div class="form-group">\n' +
        '\t\t\t<label class="col-sm-3 control-label no-padding-right" for="form-field-tags">Tag input</label>\n' +
        '\n' +
        '\t\t\t<div class="col-sm-9">\n' +
        '\t\t\t\t<input type="text" name="tags" id="form-field-tags" value="Tag Input Control" placeholder="Enter tags ..." />\n' +
        '\t\t\t</div>\n' +
        '\t\t</div>\n' +
        '\n' +
        '\t\t<div class="clearfix form-actions">\n' +
        '\t\t\t<div class="col-md-offset-3 col-md-9">\n' +
        '\t\t\t\t<button class="btn btn-info" type="button">\n' +
        '\t\t\t\t\t<i class="icon-ok bigger-110"></i>\n' +
        '\t\t\t\t\tSubmit\n' +
        '\t\t\t\t</button>\n' +
        '\n' +
        '\t\t\t\t&nbsp; &nbsp; &nbsp;\n' +
        '\t\t\t\t<button class="btn" type="reset">\n' +
        '\t\t\t\t\t<i class="icon-undo bigger-110"></i>\n' +
        '\t\t\t\t\tReset\n' +
        '\t\t\t\t</button>\n' +
        '\t\t\t</div>\n' +
        '\t\t</div>\n' +
        '\n' +
        '\t\t<div class="hr hr-24"></div>\n' +
        '\n' +
        '</form>'
    });

    // $.ajax({
    //     url:'/list/findalltab',
    //     type:'POST',
    //     // data:{s:"gg"},
    //     success:function (data) {
    //         // alert(data);
    //     }
    // });
}