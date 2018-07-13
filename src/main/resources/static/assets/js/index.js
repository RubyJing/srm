var go;
function initpage() {
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