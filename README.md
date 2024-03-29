# Speech API
Java Technical Challenge by LegalSight

Submitted by: AJ Albaniel / ajalbaniel@gmail.com

## Setup

To build and run the application
```console
foo@bar ~ % : cd legalsight
foo@bar legalsight % : make all
```
> _App will connect to tidbcloud database_

> [!IMPORTANT]
> [Postman collection](https://github.com/ajalbaniel/legalsight/blob/main/Java%20Technical%20Challenge.postman_collection.json) is attached as project file, which you can use immediately once the app is running.

<details>
    <br/>
    <p><i>Example requests are provided in the postman collection</i></p>
    <img width="379" alt="image" src="https://github.com/ajalbaniel/legalsight/assets/3489342/7a7f94d8-e6c0-4b5f-9ff6-9b1a7ea1ff80">
</details>

## API Documentation

**Endpoints URLs**

List speeches (with search and pagination)
```http
GET /speeches
```
Get speech
```http
GET /speeches/:id
```
Create speech
```http
POST /speeches
```
Update speech
```http
PUT /speeches/:id
```
Delete speech
```http
DELETE /speeches/:id
```


**Schema definition**

| Field | Type | Constraints | Example |
| :--- | :--- | :--- | :--- |
| `content` | `string` | Required | `The quick brown fox jumped over the lazy dog.` |
| `author.name` | `string` | Required | `AJ Albaniel` |
| `dateGiven` | `date` | Required | `2005-11-26` |
| `subjectAreas` | `string[]` |  | `["fox", "dog"]` |


**Sample JSON**
```json
{
    "id": "7e92fcd5-2cc9-4fa0-9a4c-e9eefc82b87e",
    "content": "The quick brown fox jumped over the lazy dog",
    "author": {
        "name": "AJ Albaniel"
    },
    "dateGiven": "2005-11-26",
    "subjectAreas": [
        "fox",
        "dog"
    ]
}
```

**Listing API parameters**

_All parameters are optional_
| Parameter | Type | Description | Example |
| :--- | :--- | :--- | :--- |
| `page` | `int` | Page number  |  `0` |
| `sort` | `string` | Sorting |  `dateGiven,desc` |
| `size` | `int` | Number of records per page |  `5` |
| `subjectAreas` | `string` | Comma-separated. If any matches |  `dog, fox` |
| `author` | `string` |  |  `AJ Albaniel` |
| `dateGivenFrom` | `date` | Any speech given *later* and during specified date |  `2005-11-24` |
| `dateGivenTo` | `date` | Any speech given *prior* and during specified date |  `2005-11-28` |
| `contentSnippet` | `string` | Snippet of text from the speech body |  `jumped over` |

> `dateGivenFrom` and `dateGivenTo` can both be specified to act as date range
