package com.command.issue

import org.apache.commons.lang.builder.HashCodeBuilder

/**
 * Created by Dmitry Lesnikovich.
 */
class UserConnection implements Serializable {

    String userId
    String providerId
    String providerUserId
    String displayName
    String profileUrl
    String imageUrl
    String accessToken
    String secret
    String refreshToken
    Long rank
    Long expireTime

    static constraints = {
        userId nullable: false
        providerId nullable: false
        providerUserId nullable: false
        displayName nullable: true
        profileUrl nullable: true
        imageUrl nullable: true
        accessToken nullable: false
        secret nullable: true
        refreshToken nullable: true
        rank nullable: false
        expireTime nullable: true
    }

    static mapping = {
        table "UserConnection"
        version false

        userId column: 'userId'
        providerId column: 'providerId'
        providerUserId column: 'providerUserId'
        displayName column: 'displayName'
        profileUrl column: 'profileUrl'
        imageUrl column: 'imageUrl'
        accessToken column: 'accessToken'
        secret column: 'secret'
        refreshToken column: 'refreshToken'
        rank column: 'rank'
        expireTime column: 'expireTime'
    }


    boolean equals(other) {
        if (!(other instanceof UserConnection)) {
            return false
        }

        other.userId == userId && other.providerId == providerId && other.providerUserId == providerUserId
    }

    int hashCode() {
        def builder = new HashCodeBuilder()
        builder.append userId
        builder.append providerId
        builder.append providerUserId
        builder.toHashCode()
    }
}