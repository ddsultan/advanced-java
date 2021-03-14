## Running Features
- Good practice
```sh
./gradlew cucumber -Dcucumber.filter.tags="@good"
```
- Bad practice (for comparison or for context)
```sh
./gradlew cucumber -Dcucumber.filter.tags="@bad"
```
## Notes
### Check java (home) info:

- `echo $JAVA_HOME`
- `java -XshowSettings:properties -version`
- `java -XshowSettings:properties -version 2>&1 > /dev/null | grep 'java.home'`

### Fix sdk not found in ZSH Mac
```sh
# SDKMAN
export SDKMAN_DIR="$HOME/.sdkman"
[[ -s "$HOME/.sdkman/bin/sdkman-init.sh" ]] && source "$HOME/.sdkman/bin/sdkman-init.sh"
```