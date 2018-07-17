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
    $.ajax({
        url:'/list/findalltab',
        type:'POST',
        // data:{s:"gg"},
        success:function (data) {
            var opt_html ="";
            for ( var i = 0; i <data.length; i++){
                opt_html += "<option value='"+data[i]+"'>"+data[i]+"</option>";
            }
            layer.open({
                type: 1,
                title: '添加新的同步表',
                shadeClose: true,
                shade: 0.8,
                anim:4,
                area: ['720px', '500px'],
                content: '<form class="form-horizontal" role="form">\n' +
                '\t\n' +
                '\t\t<div class="form-group">\n' +
                '\t\t\t\n' +
                '\t\t\t<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 需要同步的表 </label>\n' +
                '\n' +
                '\t\t\t<div class="col-sm-5">\n' +
                '\t\t\t\t<select class="form-control" id="table-select">\n' +
                '\t\t\t\t\t<option value="">&nbsp;</option>\n' +
                opt_html+
                '\t\t\t\t</select>\n' +
                '\t\t\t</div>\n' +
                '\t\t</div>\n' +
                '\n' +
                '\t\t<div class="space-4"></div>\n' +
                '\n' +
                '\t\t<div class="form-group">\n' +
                '\t\t\t<label class="col-sm-3 control-label no-padding-right" for="form-input-readonly"> 同步频率（小时/每次） </label>\n' +
                '\n' +
                '\t\t\t<div class="col-sm-8">\n' +
                '\t\t\t\t<input type="text" class="col-xs-10 col-sm-7" id="form-input-readonly" value="" />\n' +
                '\t\t\t</div>\n' +
                '\t\t</div>\n' +
                '\n' +
                '\t\t<div class="space-4"></div>\n' +
                '\n' +
                // '\t\t<div class="form-group">\n' +
                // '\t\t\t\n' +
                // '\t\t\t<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 同步单位 </label>\n' +
                // '\n' +
                // '\t\t\t<div class="col-sm-7">\n' +
                // '\t\t\t\t<select class="form-control" id="table-select">\n' +
                // '\t\t\t\t\t<option value="分钟">分钟</option>\n' +
                // '\t\t\t\t\t<option value="小时">小时</option>\n' +
                // '\t\t\t\t\t<option value="日">日</option>\n' +
                // '\t\t\t\t\t<option value="月">月</option>\n' +
                // '\t\t\t\t</select>\n' +
                // '\t\t\t</div>\n' +
                // '\t\t</div>\n' +
                // '\n' +
                //
                // '\t\t<div class="space-4"></div>\n' +
                // '\n' +
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
        }
    });

}