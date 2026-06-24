#!/usr/bin/env bash
set -euo pipefail

cd "$(dirname "$0")"

export PGPASSWORD=$POSTGRES_PASSWORD
export PGUSER=$POSTGRES_USER
export PGHOST=${POSTGRES_HOSTNAME:-localhost}
export PGDATABASE=$POSTGRES_DB

psql -a -f ./data.sql