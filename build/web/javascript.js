function inTheWorld() {
    //if user wants to search in the world - on click on label "the world" form-input will be filled
    document.getElementById("place").value = "the World";
}
    
function showDiv(search, show, map) {
    //show hidden div with search result - for pages 
    //index, hashtags and sentiments
    var searchDiv = document.getElementById(search);
    var listDiv = document.getElementById(show);    
    var onmap = document.getElementById(map);
    
    searchDiv.style.display = "none";
    listDiv.style.display = "block";    
    onmap.innerHTML = "on a Google map";
}    

function newSearch(search, hide, map){
    //hide result div and show search div again - for pages index, hashtags and sentiment
    var searchDiv = document.getElementById(search);
    var listDiv = document.getElementById(hide);    
    var onmap = document.getElementById(map);
    
    searchDiv.style.display = "block";
    listDiv.style.display = "none";
    onmap.innerHTML = "...or pick a place on a Google Map";
}   

function showText(label, place){
    //put user input from search to a label in result div  - for the page index.html
    var label = document.getElementById(label);
    var place = document.getElementById(place);
    if (place.value == "") {
        place.value = "the World";
    }
    label.innerHTML = "List of trending topics in <i><b>"+ place.value + "</b></i>";
}

function showTextSent(label, topic, place){
    //put user input from search to a label in result div  - for the page sentiment.html
    var label = document.getElementById(label);
    var topic = document.getElementById(topic);
    var place = document.getElementById(place);
    
    if (place.value == "") {
        place.value = "the World";
    }
    if (topic.value == "") {
        topic.value = "#football";    
    }
    label.innerHTML = "Sentiment of the Topic <b><i>"+ topic.value + "</i> in "+ place.value + "</b>";
}

function showTextHash(label, topic, place, sent){
    //put user input from search to a label in result div  
    //for the page hashtags.html
    var label = document.getElementById(label);
    var topic = document.getElementById(topic);
    var place = document.getElementById(place);
    var sentim = document.getElementById(sent);
    
    //default value for place
    if (place.value == "") {
        place.value = "the World";
    }
    //default value for topic
    if (topic.value == "") {
        topic.value = "#football";    
    }
    if (sentim.checked ==true){
       label.innerHTML = "Hashtags-Tree for the <i>"+ topic.value +
            "</i> in <i>"+ place.value + " with sentiments</i>"; 
    }
    else{
        label.innerHTML = "Hashtags-Tree for the <b><i>"+ topic.value + 
             "</i> in "+ place.value + "</b>";
    }
    document.getElementById("root").innerHTML = "Root <br><b>" + topic.value +"</b>";
}


function chosenTrend(t){
    //show clicked topic in the label in the right part of a result-div on index.html
    var s = t.innerText;
    if (s != null) {
        document.getElementById("chosen").innerHTML = s; 
        document.getElementById("hidHash").value = s;
        document.getElementById("hidSent").value = s;
        alert (document.getElementById("hid").value);
    }
}

function buttonClicked(name){
    document.getElementById(name).value = "clicked";
}
function drawChart(){
//draw chart with sample data for the page sentiment.html
    
// set the data
  var data = [
      {x: "Very Positive", value: 11, fill: "#004ba0"},  
      {x: "Positive", value: 380, fill: "#a3cde0"},
      {x: "Neutral", value: 234, fill: "#ccc"},
      {x: "Negative", value: 400, fill: "salmon"},
      {x: "Very negative", value: 75, fill: "crimson"}
          
  ];

  
  var chart = anychart.pie();
    // disable the legend
    //chart.legend(false);
    
    chart.tooltip().background().fill("#663399");
    chart.background().fill("");
    
  chart.data(data);

  // display the chart in the container
  chart.container('chart');
  chart.draw();
  
}

function deleteChart(){
   document.getElementById("chart").innerHTML = "";  
      //chart.dispose();
      //chart = null;
  
}

