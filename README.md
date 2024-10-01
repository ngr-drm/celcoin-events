<h3>CELCOIN EVENTS</h3>

<h4>Motivation</h4>

Technical studies and experiments

<h4>Further information</h4>

_A proof of concept aimed at validating a banking events ingestion service into an AWS cloud data lake._

Main Technologies: **Spring Boot AWS (SNS SQS Lambda S3)**

Flow Details:
 - Events are published to an SNS topic
 - An SQS queue subscribes to the SNS topic and receives the published events
 - The SQS queue triggers a Lambda function upon receiving events
 - The Lambda function processes the events and stores them in S3