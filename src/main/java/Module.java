public class Module {
    ModuleType type;
    
    public Module(ModuleType type) {
        this.type = type;
    }

    public Module(char c) {
        this.type = switch (c) {
            case 'H' ->  ModuleType.H;
            case 'B' ->  ModuleType.B;
            case 'S' ->  ModuleType.S;
            case 'O' ->  ModuleType.O;
            default -> throw new IllegalStateException("Unexpected value: " + c);
        };
    }
    
    public String getDescription(){
        String description= switch (type) {
            case H ->  "High speed transit - optimized";
            case B ->  "Balanced";
            case S ->  "Storage access time - optimized";
            case O ->  "Out of service";
        };
        return description;
    }

    public double getDriveThruSpeed(){
        double driveThruSpeed= switch (type) {
            case H ->  0.5;
            case B ->  1.0;
            case S ->  2;
            case O ->  0;
        };
        return driveThruSpeed;
    }

    public double getPickUpTime(int n){
        double pickUpTime= switch (type) {
            case H ->  3*n+4;
            case B ->  2*n+2;
            case S ->  n+1;
            case O ->  0;
        };
        return pickUpTime;
    }
}
