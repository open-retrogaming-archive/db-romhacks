# Database Of Romhacks

## Objective
This repository contains in a 'structured' way, both 'information' and 'patches' related with romhacks.

This is mainly an archival project, it CANNOT replace the original community sites.

It 'normalizes' the original patches distributions into a structure that is easier to process automatically to:
- Build romhacks collections given that the user has a copy of the original game rom.
- Generate DAT files to use in rom managers to validate collections.

## Directories
There is two main categories 'hacks' and 'translations'

```
System Name
    |- Game Name / Rom Name:
        |- hacks:
            |- Romhack Name
                |- romhack.bps
                |- romhack.xml
                |- romhack-docs:
                    |- ...
        |- translations:
            | - two-letter-iso-language-code: https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes
                |- Translation Name
                    |- romhack.bps
                    |- romhack.xml
                    |- romhack-docs:
                        |- ...
```

## Files
romhack.xml Example:
```
  <romhack>
    <name>Bishoujo Senshi Sailor Moon - Another Story</name>
    <patchtype>bps</patchtype>
    <baseCRC>02A442B8</baseCRC>
    <patchCRC>2144DF1C</patchCRC>
    <finalCRC>EEC0F601</finalCRC>
    <author>Bishoujo Senshi Translations</author>
    <url>https://www.romhacking.net/translations/4654/</url>
    <version>2.05</version>
    <releasedate>2020-06-05</releasedate>
    <status>Fully Playable</status>
    <notes>This is a complete English relocalization of Bishoujo Senshi Sailor Moon - Another Story, an RPG for the Super Famicom. Featured are several fixes to issues and bugs in the original game.</notes>
  </romhack>
```

releasedate: SHOULD follow the pattern YYYY-MM-DD.
status: One of the two 'Fully Playable' or 'Incomplete'.

## Optional Patches
Some romhacks contain a myriad of optional patches, this projects prefers to normalize such options under a few curated ones released as different romhacks under the same game.

## Providing Changes to the repository
- 1 Commit -> 1 Romhack
- Commit Message -> Romhack name