# WebServiceDemoJava
Java Demo project for Scoreg WebServices

## Common instructions
All samples are implemented as JUnit Tests. The access credentials are not stored in the source files, but have to be passed in as System properties. These can be passed as VM arguments:
```
-Dwsusername=<username> -Dwspassword=<password> -DwsaccessKey=<accessKey> -Dwshost=https://www.scoreg.at/
```

## REST Services
The base URL for REST services is `ScoregWebServer/services/v1/`

*Authentication*
Currently the authentication credentials are passed as path parameters within the request. The current WebService URL is built up with the pattern `<host>/ScoregWebServer/services/v1/<service>/<method>/<username>/<password>/<organizationId>/<webserviceId>/<parameter>`
Starting with Release 17.02 all REST Services will require authentication via HTTP Basic Auth and passing the Access Key (new and different to the current webServiceId) as HTTP Header accessKey.

### MemberService
The MemberService is located at `member`
#### Method findMemberCompleteByScoutId
up to 16.11: `https://www.scoreg.at/ScoregWebServer/services/v1/member/findMemberCompleteByScoutId/<username>/<password>/<organizationId>/<webserviceId>/<scoutId>`

after 17.02: `https://www.scoreg.at/ScoregWebServer/services/v1/member/findMemberCompleteByScoutId/<scoutId>`

#### Method findMemberByScoutId
up to 16.11: `https://www.scoreg.at/ScoregWebServer/services/v1/member/findMemberByScoutId/<username>/<password>/<organizationId>/<webserviceId>/<scoutId>`

after 17.02: `https://www.scoreg.at/ScoregWebServer/services/v1/member/findMemberByScoutId/<scoutId>`
