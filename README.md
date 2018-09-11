# WebServiceDemoJava
Java Demo project for Scoreg WebServices

## Common instructions
All samples are implemented as JUnit Tests. The access credentials are not stored in the source files, but have to be passed in as System properties. These can be passed as VM arguments:
```
-Dwsusername=<username> -Dwspassword=<password> -DwsaccessKey=<accessKey> -Dwshost=https://www.scoreg.at/ -DwsserviceId=<webserviceId> -DwsorgId=<orgId>
```

## REST Services
The base URL for REST services is `ScoregWebServer/services/v1/`

*Authentication*
Currently the authentication credentials are passed as path parameters within the request. The current WebService URL is built up with the pattern `<host>/ScoregWebServer/services/v1/<service>/<method>/<username>/<password>/<organizationId>/<webserviceId>/<parameter>`
Starting with Release 17.03 all REST Services will require authentication via HTTP Basic Auth and passing the Access Key (new and different to the current webServiceId) as HTTP Header accessKey.
For compatibility reasons the current behavior will remain for a while.

See `RestServiceTest` and `RestServiceAuthTest` for details on building the request URL and creating authentication HTTP headers. 

### MemberService
The MemberService is located at `/memberV2`. Access is restricted to user roles "WS_MEMBER_TROOP", "WS_MEMBER_DIVISION", "WS_MEMBER_FEDERATION".
See `MemberServiceTest` for example with current authentication and `MemberServiceAuthTest` for future authentication.

#### Method findScoutIdsForOrganization
`https://www.scoreg.at/ScoregWebServer/services/v1/memberV2/findScoutIdsForOrganization`

#### Method findMemberCompleteByScoutId
`https://www.scoreg.at/ScoregWebServer/services/v1/memberV2/findMemberCompleteByScoutId/<scoutId>`

#### Method findMemberByScoutId
`https://www.scoreg.at/ScoregWebServer/services/v1/memberV2/findMemberByScoutId/<scoutId>`

### AusbildungService
The AusbildungService is located at `/ausbildung`. This is used for Division-level API access and limited to users with Role "WS_AUSBILDUNG_DIVISION".

#### Method findScoutIdsForOrganization
`https://www.scoreg.at/ScoregWebServer/services/v1/ausbildung/findScoutIdsForOrganization`

#### Method findMemberByScoutId
`https://www.scoreg.at/ScoregWebServer/services/v1/ausbildung/findMemberByScoutId/<scoutId>`

### EventService (deprecated)
The EventService is located at `/event`.

#### Method findEventByCode
`https://www.scoreg.at/ScoregWebServer/services/v1/event/findEventByCode/<username>/<password>/<organizationId>/<webserviceId>/<eventCode>`

#### Method findEventById
`https://www.scoreg.at/ScoregWebServer/services/v1/event/findEventById/<username>/<password>/<organizationId>/<webserviceId>/<eventId>`

#### Method findEventIdsByMember
`https://www.scoreg.at/ScoregWebServer/services/v1/event/findEventIdsByMember/<username>/<password>/<organizationId>/<webserviceId>/<memberId>`

#### Method findEventIdsForOrganization
`https://www.scoreg.at/ScoregWebServer/services/v1/event/findEventIdsForOrganization/<username>/<password>/<organizationId>/<webserviceId>/<organizationId>`

### JobService (deprecated)
The JobService is located at `/job`.

#### Method findJobByCode
`https://www.scoreg.at/ScoregWebServer/services/v1/job/findJobByCode/<username>/<password>/<organizationId>/<webserviceId>/<jobCode>`

### MemberJobService (deprecated)
The MemberJobService is located at `/memberJob`.

#### Method findMemberJobsByScoutId
`https://www.scoreg.at/ScoregWebServer/services/v1/memberJob/findJobByCode/<username>/<password>/<organizationId>/<webserviceId>/<scoutId>`

### OrganizationService (deprecated)
The OrganizationService is located at `/organization`.

#### Method findOrganizationByCode
`https://www.scoreg.at/ScoregWebServer/services/v1/organization/findOrganizationByCode/<username>/<password>/<organizationId>/<webserviceId>/<organizationCode>`

#### Method findOrganizationByAbbreviation
`https://www.scoreg.at/ScoregWebServer/services/v1/organization/findOrganizationByCode/<username>/<password>/<organizationId>/<webserviceId>/<organizationAbbreviation>`


