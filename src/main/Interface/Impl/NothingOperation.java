
package main.Interface.Impl;

import main.Interface.StringOperations;

public class NothingOperation implements StringOperations {
    @Override
    public String apply(String subString) {
        return subString;
    }
}



