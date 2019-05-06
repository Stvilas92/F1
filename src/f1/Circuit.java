package f1;

import javax.swing.ImageIcon;

/**
 *
 * @author alejavilas92
 */
public class Circuit {
    private ImageIcon map;
    private String name,aerodinamic,city,tireWear,grip;
    private double raceLentht,elevation;
    private int length,laps,speed,rigthCurve,leftCurve,fansCapcity;
    
    public Circuit(int index,String name,String aerodinamic,String city,
            String tireWear,String grip,double raceLentht,double elevation,
            int length,int laps,int speed,int rigthCurve,int leftCurve,int fansCapcity){
        switch(index){
            case 0:
                this.map = new ImageIcon(Circuit.class.getResource("/Images/Circuits/australia.jpg"));
                break;
            case 1:
                this.map = new ImageIcon(Circuit.class.getResource("/Images/Circuits/Barhein.jpg"));
                break;
            case 2:
                this.map = new ImageIcon(Circuit.class.getResource("/Images/Circuits/china.jpg"));
                break;
            case 3:
                this.map = new ImageIcon(Circuit.class.getResource("/Images/Circuits/baku.jpg"));
                break;
            case 4:
                this.map = new ImageIcon(Circuit.class.getResource("/Images/Circuits/catalunya.jpg"));
                break;
        }
        
        this.name = name;
        this.aerodinamic = aerodinamic;
        this.city = city;
        this.tireWear = tireWear;
        this.grip = grip;
        this.raceLentht = raceLentht;
        this.elevation = elevation;
        this.length = length;
        this.laps = laps;
        this.speed = speed;
        this.rigthCurve = rigthCurve;
        this.leftCurve = leftCurve;
        this.fansCapcity = fansCapcity;
    }

    public ImageIcon getMap() {
        return map;
    }

    public void setMap(ImageIcon map) {
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAerodinamic() {
        return aerodinamic;
    }

    public void setAerodinamic(String aerodinamic) {
        this.aerodinamic = aerodinamic;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTireWear() {
        return tireWear;
    }

    public void setTireWear(String tireWear) {
        this.tireWear = tireWear;
    }

    public String getGrip() {
        return grip;
    }

    public void setGrip(String grip) {
        this.grip = grip;
    }

    public double getRaceLentht() {
        return raceLentht;
    }

    public void setRaceLentht(double raceLentht) {
        this.raceLentht = raceLentht;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getRigthCurve() {
        return rigthCurve;
    }

    public void setRigthCurve(int rigthCurve) {
        this.rigthCurve = rigthCurve;
    }

    public int getLeftCurve() {
        return leftCurve;
    }

    public void setLeftCurve(int leftCurve) {
        this.leftCurve = leftCurve;
    }

    public int getFansCapcity() {
        return fansCapcity;
    }

    public void setFansCapcity(int fansCapcity) {
        this.fansCapcity = fansCapcity;
    }
    
    
}
