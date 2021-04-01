FROM mozilla/sbt

RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    git \
    bash-completion

RUN useradd -ms /bin/bash sbtuser

USER sbtuser