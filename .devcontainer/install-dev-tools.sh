#!/bin/bash

apt-get update && \
  apt-get install -y --no-install-recommends  git

USER_HOME=/root

git clone https://github.com/magicmonty/bash-git-prompt.git $USER_HOME/.bash-git-prompt --depth=1

cat <<EOT >> $USER_HOME/.bashrc
if [ -f "$USER_HOME/.bash-git-prompt/gitprompt.sh" ]; then
    GIT_PROMPT_ONLY_IN_REPO=1
    source $USER_HOME/.bash-git-prompt/gitprompt.sh
fi
EOT