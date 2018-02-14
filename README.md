# CSV-XML-Converter

This program will convert a csv file to an xml file.

## How to Use

* Navigate to source folder  
```
javac Convert.java #This will compile the Java file to a class file.

java Convert <fileName>
```

## Testing

There are also unit tests that are provided within the `ConvertTest.java`file.

These tests can be run using JUinit.

## Test Cases

### Test Normal File
This test will ensure that the program can properly convert a csv file to an xml file.

### Test Missing Fields
This test will ensure that the program can prperly convert a csv file that has missing data to an xml file.
### Test Large File
This test will ensure that the program can handle large csv files.

### Test Invalid File
This test will ensure that no XML is created when passing a file that does not exist.

### Test No Extension

This test will ensure that no XML is created when passing a file with no extension.

### Test Wrong Extension
This test will ensure that the an XML file is not created when passing in an invalid file type. (Any file that is not a csv)


## Production Ready Features

For this project to be production ready I would like to add the following features.
* GUI
* Allow different file inputs and outputs
* Allow editing of data before conversion
* Allow users to convert multiple files at the same time

