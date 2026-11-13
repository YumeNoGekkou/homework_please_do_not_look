set -euo pipefail

_root="$(pwd)"
# _src="$_root/src"
# _build="$_root/build"
# mkdir -p "$_build"
# javac -d "$_build" "$_src"/*.java
# java -cp "$_build" Main

#"$_root"/mvnw clean test package exec:java
"$_root"/mvnw clean test package
