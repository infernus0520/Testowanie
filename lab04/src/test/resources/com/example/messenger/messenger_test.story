Given a messenger
When set arguments to VALID_SERVER and VALID_MESSAGE
Then send should return SendingStatus.Sent

When set argument to VALID_SERVER
Then checkConnection should return ConnectionStatus.SUCCESS

When set arguments to VALID_SERVER and INVALID_MESSAGE
Then send should throw MalformedRecipientException

When set argument to INVALID_SERVER
Then chceckConnection should return ConnectionStatus.FAILURE

When set arguments to INVALID_SERVER and VALID_MESSAGE
Then send should return SendingStatus.SENDING_ERROR


