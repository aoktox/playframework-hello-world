#!/bin/bash

if [[ -f /home/ubuntu/playframework/RUNNING_PID ]]; then
    pid=$(cat /home/ubuntu/playframework/RUNNING_PID)
    sudo kill -9 ${pid}
fi

sudo rm -rf /home/ubuntu/playframework
mkdir /home/ubuntu/playframework