# WebServiceDemoJava
Java Demo project for Scoreg WebServices

## Common instructions
All samples are implemented as JUnit Tests. The access credentials are not stored in the source files, but have to be passed in as System properties. These can be passed as VM arguments:
```
-Dwsusername=<username> -Dwspassword=<password> -DwsaccessKey=<accessKey> -Dwshost=https://www.scoreg.at/
```

## REST Services
The base URL for REST services is `ScoregWebServer/services/v1/`
All REST Services require authentication via HTTP Basic Auth and passing the Access Key as HTTP Header accessKey.
### MemberService
The MemberService is located at `member`
#### Method findMemberCompleteByScoutId
