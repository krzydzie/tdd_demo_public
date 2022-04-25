# tdd_demo_public

## Branch "base-level"

start point

## Branch "tdd-detailed"

the final solution

## Git tags with steps

| git tag | description                                                                                                                |
| ------- | -------------------------------------------------------------------------------------------------------------------------- |
| tag00   | init                                                                                                                       |
| tag01   | red - JobListServiceTest - initial tests findJobByJiraTicket(), jobListEmpty(); jobListService does not exist              |
| tag02   | JobListService - created empty class JobListService to have in the package                                                 |
| tag03   | JobListServiceTest - initialized jobListService                                                                            |
| tag04   | yellow - JobListService - Created fixed JobListService.getStatusByTicketNumber()                                           |
| tag05   | red - JobListService - implemented JobListService.getStatusByTicketNumber(), requestService and jobsUrl does not exist     |
| tag06   | RequestService - created empty class RequestService to have in the package                                                 |
| tag07   | JobListService - constructor with jobsUrl, requestService, JobListServiceTest needs update of JobListService() parameters  |
| tag08   | JobListServiceTest - updating JobListService() parameters                                                                  |
| tag09   | RequestService - getJson() added                                                                                           |
| tag10   | green - JobListServiceTest - mocking requestService.getJson()                                                              |
| tag11   | red - JobListService - for findJobByJiraTicket() added jobFinder                                                           |
| tag12   | created empty class JobFinder to have in the package                                                                       |
| tag13   | JobListService, JobListServiceTest - initialized jobFinder                                                                 |
| tag14   | JobFinder - added findByDescription()                                                                                      |
| tag15   | yellow - JobListServiceTest - initialized jobFinder                                                                        |
| tag16   | JobFinderTest - initial tests for findByDescription() - not to forget                                                      |
| tag17   | green - JobListServiceTest - mocking jobFinder.findByDescription()                                                         |
| tag18   | yellow - JobListServiceTest - empty tests for jobs pending in html                                                         |
| tag19   | JobListServiceTest - implemented tests for jobs pending in html                                                            |
| tag20   | red - JobListService - added requestService.getText(), jobFinder.findInHtml()                                              |
| tag21   | RequestService - added getText()                                                                                           |
| tag22   | JobFinder - added findInHtml()                                                                                             |
| tag23   | green - JobListServiceTest - mocking requestService.getText(), jobFinder.findInHtml()                                      |
| tag24   | yellow - JobFinderTest - initialized foundInHtml(), notFoundInHtml()                                                       |
| tag25   | JobFinderTest - all tests implemented                                                                                      |
| tag26   | red - JobFinder - implemented findByDescription()                                                                          |
| tag27   | JobService - created empty class JobService to have in the package                                                         |
| tag28   | JobFinder, JobFinderTest - initialized jobService                                                                          |
| tag29   | JobService - added empty getJob()                                                                                          |
| tag30   | yellow - JobFinderTest - initialized jobService                                                                            |
| tag31   | green - JobFinderTest - mocking jobService.getJob() in tests findByDescriptionXxxx()                                       |
| tag32   | yellow - JobServiceTest - initialized jobFound(), jobNotFound()                                                            |
| tag33   | blue - JobFinder - refactoring: extracted method checkJob()                                                                |
| tag34   | green - JobFinder - implemented findInHtml()                                                                               |
| tag35   | red - JobServiceTest - implemented: jobFound(), jobNotFound()                                                              |
| tag36   | yellow - JobServiceTest - jobService initialized                                                                           |
| tag37   | red - JobService - implemented getJob() - requestService, jobsUrl do not exist                                             |
| tag38   | JobService - initialized jobsUrl, requestService                                                                           |
| tag39   | JobServiceTest - initialized DUMMY_URL, requestService in JobService                                                       |
| tag40   | green - JobServiceTest - mocked requestService.getJson()                                                                   |
