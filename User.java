public class User {
    private final String name, email, password, role;

  
    private User(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.role = builder.role;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    
    public static class Builder {
        private String name, email, password, role;

        public Builder setName(String n) {
            this.name = n;
            return this;
        }

        public Builder setEmail(String e) {
            this.email = e;
            return this;
        }

        public Builder setPassword(String p) {
            this.password = p;
            return this;
        }

        public Builder setRole(String r) {
            this.role = r;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}