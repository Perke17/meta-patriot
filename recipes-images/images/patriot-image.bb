SUMMARY = "The Patriot Image"
DESCRIPTION = "An animated flag"

LICENSE = "MIT"
inherit core-image

#start of the resulting deployable tarball name
export IMAGE_BASENAME = "Patriot-Image"
MACHINE_NAME ?= "${MACHINE}"
IMAGE_NAME = "${MACHINE_NAME}_${IMAGE_BASENAME}"

SYSTEMD_DEFAULT_TARGET = "graphical.target"

IMAGE_FEATURES += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11', \
                                                       '', d), d)} \
"

#inherit populate_sdk_qt5

IMAGE_LINGUAS = "en-us"

ROOTFS_PKGMANAGE_PKGS ?= '${@oe.utils.conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "${ROOTFS_PKGMANAGE}", d)}'

QT5_LIBS ?= " \
    qtbase \
    qtdeclarative \
    qtxmlpatterns \
"

IMAGE_INSTALL += " \
    ${QT5_LIBS} \
    qtlottie \
    patriot \
    wayland \
    weston weston-init weston-examples libdrm-tests \
"

IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "busybox shadow"
