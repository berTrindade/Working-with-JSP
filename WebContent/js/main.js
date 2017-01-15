
// Link: https://www.developphp.com/video/JavaScript/Checkbox-Toggle-Tutorial-Select-Deselect-All-Elements
function checkAll(checkBox, group)
{
	var checkboxes = document.getElementsByName(group);
	
	for (var i = 0; i < checkboxes.length; i++) 
		checkboxes[i].checked = checkBox.checked;
}

function validateForm(group)
{
    var checkboxes = document.getElementsByName(group);
    var isValid = false;
    
    for(var i = 0; i < checkboxes.length; i++)
    {
        if(checkboxes[i].checked)
        {
        	isValid = true;
            break;
        }
    }

    if(!isValid)
    {
    	alert("Please check at least one Checkbox!");
    	return false;
    } else 
    	return true;
}