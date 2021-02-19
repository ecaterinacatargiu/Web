var imgArray = []

function shuffle(a)
{
    var i,j,x;
    for(i=a.length;i;i--)
    {
        j = Math.floor(Math.random() * i);
        x = a[i-1];
        a[i-1]=a[j];
        a[j]=x;
    }
}

function init()
{
    for(x=0;x<3;++x)
        for(y=0;y<3;++y)
        {
            img = new Image();
            img.src = "pisi/"+x+'-'+y+".jpg";
            img.className = "puzzlepiece";
            img.id = x*3+y;
            img.width = 100;
            img.height = 100;
            img.onclick = function()
                {
                    imgClick(this);
                }
            imgArray.push(img);
        }
    shuffle(imgArray);
    showPuzzle();
}


function showPuzzle()
{
    var puzzle = "";
    document.getElementById('puzzle').innerHTML = "";
    var done = true;
    for(var x = 0; x< imgArray.length;++x)
    {
        if(imgArray[x].id != x)
            done=false;
        
        document.getElementById('puzzle').appendChild(imgArray[x]);
        console.log(imgArray[x]);
    }
    if(done)
        document.getElementById("status").innerHTML = "<p>Well done :P </p>";
}



var toSwap = null;
var idxToSwap = null;

function imgClick(img)
{
    if(toSwap == null)
    {
        toSwap = img;
        idxToSwap = imgArray.indexOf(img);
        document.getElementById('status').innerHTML = "<p>Chosen image: :</p>";

        var copy = new Image();
        copy.src = img.src;
        copy.width = img.width;
        copy.height = img.height;
        copy.className = img.className;

        copy.onclick = function () 
        {
            document.getElementById('status').innerHTML = "";
            toSwap = null;
            idxToSwap = null;
        }

        document.getElementById('status').appendChild(copy);
        return;
    }
    document.getElementById('status').innerHTML = "";
    index = imgArray.indexOf(img);
    imgArray[idxToSwap]=img;
    imgArray[index] = toSwap;
    showPuzzle();
    toSwap = null;
    idxToSwap = null;
}