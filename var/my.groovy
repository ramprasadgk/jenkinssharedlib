import groovy.transform.Field

def call(String dev_name) {
    return slack_handle(dev_name)
}

def slack_handle(String dev_name) {
    return developerList.find {it['name'] == dev_name}?.get("slack_handle")
}

def otherMethod() {
    echo "I got called"
}

@Field
def developerList = [
    [name: "Richard Lewis", slack_handle: "<@richardlewis123>"],
    [name: "Mark Turner", slack_handle: "<@markTurner123>"]
]