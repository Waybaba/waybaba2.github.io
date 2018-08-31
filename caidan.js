$(document).ready(function() {
    //添加图片，把小logo显示出来
    //这里图片是从网上拼接名字下载到的，其实可以存下来，不过是个思路，这样不用浪费服务器带宽
    $("div .subMenu>img").each(function() {//遍历每个submenu下的img
        var name = $(this).attr("data-imgname");//获取到这个img的名字
        var src = "http://www.jq22.com/img/cs/500x300-" + name + ".png"//用这个名字去组成一个地址下载
        //设置img的属性和值。
        $(this).attr("src", src);
        //attr 是用来设置值的函数 ("img").attr("width","180");
    });

    //点击事件
    $("div .subMenu").click(function() {

        var $img = $(".active>img");
        //返回被选元素的属性值
        var name = $img.attr("data-imgname");
        var src = "http://www.jq22.com/img/cs/500x300-" + name + ".png";
        $img.attr("src", src);
        // 取消当前激活状态
        $(".active").removeClass("active");
        // 添加新状态
        $(this).addClass("active");
        //找到所有 div(subMenu) 的子元素(img)
        $img = $(this).children("img");
        name = $img.attr("data-imgname");
        src = "http://www.jq22.com/img/cs/500x300-" + name + ".png";
        //设置img的属性和值。
        $img.attr("src", src);
        //上面都没看懂！！！！


        //content根据点击按钮加载不同的html
        //this指向当前函数执行的对象
        var page = $(this).attr("data-src");
        //location.href = page;
         $("#content").load(page);
        // $("#content").html(page);

        // if (page) {
        //     //location.href = "caidan_"+page+".html";
        //     widow.open(personal.html);
        // }
    });

    // 自动点击第一个菜单
    $("div .subMenu")[0].click();
});

/*content高度*/
function initSize() {
    var height = $(window).height() - $("header").height() - $("#description").height() - $("#menu").height();
    $("#content").height(height + "px");
}