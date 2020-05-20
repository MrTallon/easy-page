var initDataTable = function () {
    "use strict";
    var rowNum = 0; // 序号
    var dataTable;
    dataTable = $('#cpd-config-table').DataTable({
        autoWidth: false,
        deferRender: true,
        responsive: true,
        searching: false, //是否开启搜索
        paging: false,
        processing: false, //是否显示处理状态
        ordering: false, //排序
        info: false,
        serverSide: true, //是否开启服务器模式
        ajax: {
            "type": "GET",
            "dataType": "json",
            "url": "http://localhost:8080/index"
        },
        // TODO 待做
        columns: [
            {
                "data": "rowNum", "render": function (data, type, row, meta) {

                }
            },
            {"data": "name", "defaultContent": "--"},
            {"data": "author", "defaultContent": "--"},
            {"data": "createTime", "defaultContent": "--"},
        ],
        columnDefs: [{
            targets: [4],
            createdCell: function (td, cellData, rowData, row, col) {
                if (rowData && rowData.rowspan >= 1) {
                    $(td).closest("tr").data("rowspanNum", rowData.rowspan);
                    $(td).attr('rowspan', rowData.rowspan);
                    $(td).css("background", "#fff");
                } else if (rowData && rowData.rowspan == 0) {
                    $(td).remove();
                }
            }
        }]
    });
    // 给table绑定一个自定义刷新事件
    $('#cpd-config-table').on("table.reload", function () {
        rowNum = 0;
        dataTable.ajax.reload();
    });
}

var mainInitTable = function () {
    "use strict";
    return {
        init: function () {
            initDataTable();
        }
    };
}();