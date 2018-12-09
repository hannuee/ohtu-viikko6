/**
 *
 * @author Hannu
 */
package statistics;

import statistics.matcher.*;

public class Querybuilder {
    
    Matcher matcher;
    
    public Querybuilder() {
        this.matcher = new All();
    }
    
    public Querybuilder playsIn(String team) {
        matcher = new And(this.matcher, new PlaysIn(team));
        return this;
    }
    
    public Querybuilder hasAtLeast(int value, String key) {
        matcher = new And(this.matcher, new HasAtLeast(value, key));
        return this;
    }
    
    public Querybuilder hasFewerThan(int value, String key) {
        matcher = new And(this.matcher, new HasFewerThan(value, key));
        return this;        
    }
    
    public Querybuilder not() {
        matcher = new Not(this.matcher);
        return this;        
    }
    
    public Querybuilder oneOf(Matcher m1, Matcher m2) {
        matcher = new Or(m1, m2);
        return this;
    }
    
    public Matcher build() {
        return this.matcher;
    }
    
}
