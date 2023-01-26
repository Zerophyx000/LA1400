package panzerindustrie;
import robocode.*;
public class Sturmpanzerwagen extends JuniorRobot
{
int north = 0;
int east = 90;
int south = 180;
int west = 270;
String selectedcorner = "none";

	public void run() {
		setColors(red,red,red,red,red);
		while(true) {
			findNearestCorner();
			driveToCorner(selectedcorner);
			turnRight(360);
		}
		
	}
	
	public void driveToCorner(String corner) {
		if (corner == "northeast"){
			turnTo(north);
			turnAheadRight(fieldHeight - robotY, fieldWidth - robotX);
		}
		if (corner == "southeast"){
			turnTo(south);
			turnAheadLeft(robotY, fieldWidth - robotX);
		}
		if (corner == "northwest"){
			turnTo(north);
			turnAheadLeft(fieldWidth - robotY, robotX);
		}
		if (corner == "southwest"){
			turnTo(south);
			turnAheadRight(robotY, robotX);
		}
	}
	
	public void findNearestCorner() {
		if (robotY > (fieldHeight / 2) && robotX > (fieldWidth / 2)){
			selectedcorner = "northeast";
		}
		if (robotY < (fieldHeight / 2) && robotX > (fieldWidth / 2)){
			selectedcorner = "southeast";
		}
		if (robotY > (fieldHeight / 2) && robotX < (fieldWidth / 2)){
			selectedcorner = "northwest";
		}
		if (robotY < (fieldHeight / 2) && robotX < (fieldWidth / 2)){
			selectedcorner = "southwest";
		}
	}

	public void onScannedRobot() {
		if(scannedDistance > 200){
			fire(1);
		}
		else if(scannedDistance > 150){
			fire(1.5);
		}
		else if(scannedDistance > 100){
			fire(2);
		}
		else if(scannedDistance > 50){
			fire(3);
		}
	}
	
	public void onHitByBullet() {
		turnTo(hitByBulletBearing);
		fire(3);
	}
}
