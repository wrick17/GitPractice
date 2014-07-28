/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function table_draw() {
    var x = new XMLHttpRequest();
    x.open("get", "Show.jsp", true);
    x.send(null);
    x.onreadystatechange = function() {
        if (x.readyState == 4) {
            document.getElementById("main_content").innerHTML = x.responseText;
        }
    };
}

function edit(job_id, job_title, min_sal, max_sal) {

    var x = new XMLHttpRequest();
    x.open("get", "Edit.jsp", true);
    x.send(null);
    x.onreadystatechange = function() {
        if (x.readyState == 4) {
            document.getElementById("insert_button").style.cssText = "display: none";
    
            document.getElementById(job_id).innerHTML = "<tr id='new_row'>"
                    + "<form method=\"get\" action=\"Edit.jsp\">"
                    + "<td><input type=\"text\" id=\"job_id_textbox\" value=\"" + job_id + "\"/></td>"
                    + "<td><input type=\"text\" id=\"job_title_textbox\" value=\"" + job_title + "\"/></td>"
                    + "<td><input type=\"text\" id=\"min_sal_textbox\" value=\"" + min_sal + "\"/></td>"
                    + "<td><input type=\"text\" id=\"max_sal_textbox\" value=\"" + max_sal + "\"/></td>"
                    + "<td class='fat' colspan=2 onclick='update()'><img  id='save' src='right.png'/></td>"
                    + "</form>"
                    + "</tr>";

            var rows = document.getElementById("table").getElementsByTagName("tr").length;

            var button_element_list = document.getElementsByClassName("button");

            for (var i = 0; i < (rows - 3) * 2; i++) {
                button_element_list[i].style.display = "none";
            }
        }
    };
}

function update() {
    job_id = document.getElementById("job_id_textbox").value;
    job_title = document.getElementById("job_title_textbox").value;
    min_sal = document.getElementById("min_sal_textbox").value;
    max_sal = document.getElementById("max_sal_textbox").value;

    var x = new XMLHttpRequest();
    x.open("get", "Edit.jsp?job_id=" + job_id + "&job_title=" + job_title + "&min_sal=" + min_sal + "&max_sal=" + max_sal, true);
    x.send(null);
    x.onreadystatechange = function() {
        if (x.readyState == 4) {
            var str = x.responseText.trim();
            if (str != 'x') {
                alert(str);
            }else{
                    alert("Update Succesful");
                }
            table_draw();
        }
    };
}

function del(id) {
    if (confirm("Do you really want to delete?") == true) {
        var x = new XMLHttpRequest();
        x.open("get", "delete.jsp?var_del=" + id, true);
        x.send(null);
        x.onreadystatechange = function() {
            if (x.readyState == 4) {
                document.getElementById(id).style.display = "none";
                document.getElementById(id).style.transitionDuration = "1s";
                var str = x.responseText.trim();
                if (str != 'x') {
                    alert(str);
                }else{
                    alert("Delete Succesful");
                }
            }
        };
    }
}

function ins() {
//    alert("hello");
    document.getElementById("insert_button").style.cssText = "display: none";
    document.getElementById("newRow").style.cssText = "display: table-row";
    var rows = document.getElementById("table").getElementsByTagName("tr").length;

            var button_element_list = document.getElementsByClassName("button");

            for (var i = 0; i < (rows - 3) * 2; i++) {
                button_element_list[i].style.display = "none";
            }
}

function addRow()
{
//                alert(document.getElementById("job_id").value+document.getElementById("job_title").value+document.getElementById("min_sal").value+document.getElementById("max_sal").value);

    job_id = document.getElementById("job_id_textbox").value;
    job_title = document.getElementById("job_title_textbox").value;
    min_sal = document.getElementById("min_sal_textbox").value;
    max_sal = document.getElementById("max_sal_textbox").value;

    var x = new XMLHttpRequest();
    x.open("get", "insert.jsp?job_id=" + job_id + "&job_title=" + job_title + "&min_sal=" + min_sal + "&max_sal=" + max_sal, true);
    x.send(null);
    x.onreadystatechange = function() {
        if (x.readyState == 4) {
            var str = x.responseText.trim();
            if (str != 'x') {
                alert(str);
            }else{
                    alert("Insert Succesful");
                }
            table_draw();
        }

    };
}