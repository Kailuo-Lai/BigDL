#!/bin/bash
set -x
export USE_XETLA=OFF
export SYCL_PI_LEVEL_ZERO_USE_IMMEDIATE_COMMANDLISTS=1
source /opt/intel/oneapi/setvars.sh

if [ -d "./model" ];
then
  MODEL_PARAM="--repo-id-or-model-path ./model"  # otherwise, default to download from HF repo
fi

if [ -d "./data/english_quotes" ];
then
  DATA_PARAM="--dataset ./data/english_quotes" # otherwise, default to download from HF dataset
fi

python qlora_finetuning_cpu.py $MODEL_PARAM $DATA_PARAM

