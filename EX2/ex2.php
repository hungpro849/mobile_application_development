<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
	
	 <strong>GET DISTANCE BY USING HAVERSIN FORMULA </strong>	
	 <br>
	 <br>
	 input type  example : 10.881784, 106.804496 
	 <br>
	 <br>
	 
	<form method="post" action="<?php echo $_SERVER["PHP_SELF"] ?>">
	 	<label>input a</label>
	 	<input type="text" name="a" >
	 	<br>
	 	<br>
	 	<label>input b</label>
	 	<input type="text" name="b" >
	 	<br>
	 	
	 	
	 	<br>
	 	<button type="submit" name="result" >distance</button>
	 	
	 	
	 </form>
	 <br>

	 RESULT:<br>



<?php 

	function haversineDistance( $latitudeFrom, $longitudeFrom, $latitudeTo, $longitudeTo)
		{
		  $earthRadius = 6371;
		  $latFrom = deg2rad($latitudeFrom);
		  $lonFrom = deg2rad($longitudeFrom);
		  $latTo = deg2rad($latitudeTo);
		  $lonTo = deg2rad($longitudeTo);

		  $latDelta = $latTo - $latFrom;
		  $lonDelta = $lonTo - $lonFrom;

		  $distance = 2 * $earthRadius*asin(sqrt(pow(sin($latDelta / 2), 2) +
		    cos($latFrom) * cos($latTo) * pow(sin($lonDelta / 2), 2)));
		  return $distance;
		}
	

	if ($_SERVER["REQUEST_METHOD"] == "POST")
	{
		$a=$_POST['a'];
		$b=$_POST['b'];
		$arrayA=explode(",", $a);
		$arrayB=explode(",", $b);
		
		if ((empty($a) || empty($b))) {
			# code...
			echo "input is not empty ";
			
		}
		else
		{

			$ketqua=haversineDistance($arrayA[0], $arrayA[1],$arrayB[0], $arrayB[1]);
			$arr = array('distance' => $ketqua );
			echo json_encode($arr);
		}

	}
 ?>
</body>
</html>
