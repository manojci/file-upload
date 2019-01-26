# file-upload

File uploder Rest service which performs two operations

1) File upload of single file.

2) display the details of the file.

Endpoint -1

POST: http://localhost:9874/upload

output:
File will persisted in drive in respective mentioned location

Endpont - 2

GET: http://localhost:9874/display-data?fileName=issues.csv

response:

[
    {
        "firstName": "Petra",
        "lastName": "Boersma",
        "issuesCount": 1,
        "dateOfBirth": "2001-04-20"
    },
    {
        "firstName": "Theo",
        "lastName": "Jansen",
        "issuesCount": 5,
        "dateOfBirth": "1978-01-02"
    },
    {
        "firstName": "Fiona",
        "lastName": "deVries",
        "issuesCount": 7,
        "dateOfBirth": "1950-11-12"
    }
]

Below are the set of items covered as part of the work

1) Seggregation of packages

2) Logging using log4j. Levels of logging is different for environment

3) Multiple Environment consideration

4) Spring-Boot and Stream API usage

5) Jenkinsfile configuration for CI

6) Code Quality assurance (PMD Plugin)
