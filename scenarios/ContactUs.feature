Feature: Datacom - Contact us page
Scenario Outline: Validate contact us page

Given user navigates to the site 'https://datacom.com/nz/en/contact-us'
When user selects country <country>
Then verify city <city> contact <contact_type> information <info>

Examples:
| country | city | contact_type | info |