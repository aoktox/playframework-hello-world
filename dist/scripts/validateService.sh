#!/bin/bash
sudo apt-get install -y curl > /dev/null 2>&1 &
for i in `seq 1 30`;
do
  HTTP_CODE=$(curl --write-out '%{http_code}' -o /dev/null -m 10 -q -s http://localhost:9000)
  if [[ "$HTTP_CODE" == "200" ]]; then
    echo "Successfully pulled root page."
    exit 0;
  fi
  echo "Attempt to curl endpoint returned HTTP Code $HTTP_CODE. Backing off and retrying."
  sleep 10
done
echo "Server did not come up after expected time. Failing. Last response is : $HTTP_CODE"
exit 1