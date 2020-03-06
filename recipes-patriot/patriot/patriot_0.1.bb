SUMMARY = "PatriotApp"
DESCRIPTION = "An app that loves it's country"

S = "${WORKDIR}/git"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=2b787c0622a7b91d9f5198124854e87d"


inherit qmake5 qmake5_paths

DEPENDS += "qtlottie"

SRC_URI = "git://github.com/Perke17/PatrioticApp.git;branch=master;protocol=git"
SRCREV = "743751073d72bc4fbc2cd2f9f88bb22e10319cf8"
SRC_URI[md5sum] = "3fd7ad10dd2984ef01c95af5832ba2b1"

FILES_${PN} += "/opt/PatrioticApp/bin/PatrioticApp"

do_compile () {
    oe_runmake all
}
