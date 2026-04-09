public class Booking {
    private final int id, pax;
    private final String userName, exhibitName, date, time;
    private String status;

    private Booking(Builder builder) {
        this.id = builder.id;
        this.userName = builder.userName;
        this.exhibitName = builder.exhibitName;
        this.date = builder.date;
        this.time = builder.time;
        this.pax = builder.pax;
        this.status = builder.status;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getExhibitName() {
        return exhibitName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getPax() {
        return pax;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String s) {
        this.status = s;
    }

    public static class Builder {
        private int id, pax;
        private String userName, exhibitName, date, time, status = "Pending";

        public Builder setId(int i) {
            this.id = i;
            return this;
        }

        public Builder setUserName(String un) {
            this.userName = un;
            return this;
        }

        public Builder setExhibitName(String en) {
            this.exhibitName = en;
            return this;
        }

        public Builder setDate(String d) {
            this.date = d;
            return this;
        }

        public Builder setTime(String t) {
            this.time = t;
            return this;
        }

        public Builder setPax(int p) {
            this.pax = p;
            return this;
        }

        public Builder setStatus(String s) {
            this.status = s;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }
}